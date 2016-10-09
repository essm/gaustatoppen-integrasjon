package no.gaustatoppen.integrasjon.avtale;

public class Avtale {

    private final String kundeNummer;
    private final String navn;
    private final String adresse;
    private final String avtaleNummer;
    private final String avtaleType;

    public Avtale(String kundeNummer, String navn, String adresse, String avtaleNummer, String avtaleType) {
        this.kundeNummer = kundeNummer;
        this.navn = navn;
        this.adresse = adresse;
        this.avtaleNummer = avtaleNummer;
        this.avtaleType = avtaleType;
    }

    public String getKundeNummer() {
        return kundeNummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getAvtaleNummer() {
        return avtaleNummer;
    }

    public String getAvtaleType() {
        return avtaleType;
    }
}
