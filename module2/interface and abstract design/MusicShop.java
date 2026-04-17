public class MusicShop {
    public static void main(String[] args) 
    {
        Instrument[] instruments = new Instrument[2];
        instruments[0] = new Guitar("Fender", 2020, 6, "Electric");
        instruments[1] = new Piano("Yamaha", 2018, true);

        for (Instrument inst : instruments) {
            System.out.println(inst.getInstrumentDetails());
            System.out.println(inst.play());

            if (inst instanceof Tunable) 
            {
                Tunable t = (Tunable) inst;
                System.out.println(t.tune());
                System.out.println(t.adjustPitch(true));
            }
            if (inst instanceof Maintainable) 
            {
                Maintainable m = (Maintainable) inst;
                System.out.println(m.clean());
                System.out.println(m.inspect());
            }
            System.out.println("----------------------");
        }
    }
}