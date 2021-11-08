package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class MeldingDAOMemory {

    private static List<Melding> meldinger = new ArrayList<>();

    // Initialiserer med 3 hardkodete meldinger
    public MeldingDAOMemory() {
        lagreNyMelding(new Date().getTime(), "Per", "Første melding");
        lagreNyMelding(new Date().getTime(), "Pål", "Andre melding");
        lagreNyMelding(new Date().getTime(), "Espen", "Tredje melding");
    }

    public synchronized void lagreNyMelding(long tidspunktNaa, 
            String mottattAvsender, String mottattMelding) {

    	Melding m = new Melding(tidspunktNaa, mottattAvsender, mottattMelding);
        m.setId(meldinger.size() + 1);
        meldinger.add(0, m);
    }

    public synchronized List<Melding> henteNSisteMeldinger(int n) {
        int size = meldinger.size();
        return meldinger.subList(0, n <= size ? n : size);
    }
}
