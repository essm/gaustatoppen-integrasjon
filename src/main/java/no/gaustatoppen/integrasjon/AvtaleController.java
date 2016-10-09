package no.gaustatoppen.integrasjon;

import no.gaustatoppen.fagsystem.Fagsystem;
import no.gaustatoppen.fagsystem.status.AvtaleStatus;
import no.gaustatoppen.integrasjon.avtale.Avtale;
import no.gaustatoppen.integrasjon.avtale.Kvittering;
import no.gaustatoppen.integrasjon.brev.BrevTjeneste;
import no.gaustatoppen.integrasjon.brev.BrevTjenesteImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvtaleController {

    private final Logger logger = LoggerFactory.getLogger(AvtaleController.class);

    private final Fagsystem fagsystem = new Fagsystem(); // Fagsystem WS
    private final BrevTjeneste brevTjeneste = new BrevTjenesteImpl();

    @RequestMapping("/nyavtale")
    public Kvittering opprettAvtale(@RequestParam(value="navn") String navn,
                                    @RequestParam(value="adresse") String adresse,
                                    @RequestParam(value="avtaleType") String avtaleType)
    {
        logger.info("Oppretter " + avtaleType + "-avtale for kunde " + navn + " (" + adresse + ")");
        String kundeNummer = fagsystem.opprettKunde(navn, adresse);
        String avtaleNummer = fagsystem.opprettAvtale(kundeNummer, avtaleType);
        Avtale avtale = new Avtale(kundeNummer, navn, adresse, avtaleNummer, avtaleType);
        boolean avtaleSendtTilKunde = brevTjeneste.sendAvtaleTilKunde(avtale);
        if (avtaleSendtTilKunde) {
            String avtaleStatus = fagsystem.oppdaterAvtaleStatus(avtaleNummer, AvtaleStatus.SENDT);
            return new Kvittering(avtaleNummer, avtaleStatus);
        }
        return new Kvittering(avtaleNummer, AvtaleStatus.IKKESENDT.name());
    }
}
