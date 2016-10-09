package no.gaustatoppen.integrasjon.brev;

import no.gaustatoppen.integrasjon.avtale.Avtale;

public class BrevTjenesteImpl implements BrevTjeneste {

    @Override
    public boolean sendAvtaleTilKunde(Avtale avtale) {
        if (avtale.getAdresse().equals("HER")) {
            return false;
        }
        return true;
    }
}
