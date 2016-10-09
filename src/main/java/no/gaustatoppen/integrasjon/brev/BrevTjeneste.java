package no.gaustatoppen.integrasjon.brev;

import no.gaustatoppen.integrasjon.avtale.Avtale;

public interface BrevTjeneste {

    boolean sendAvtaleTilKunde(Avtale avtale);

}
