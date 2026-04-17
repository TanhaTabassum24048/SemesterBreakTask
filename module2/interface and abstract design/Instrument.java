abstract class Instrument {
    private String name;
    protected int year;

    public Instrument(String name, int year) 
    {
        this.name = name;
        this.year = year;
    }

    public abstract String play();

    public String getInstrumentDetails() {
        return "Name: " + name + ", Year: " + year;
    }
}
interface Tunable
{
    String tune();
    String adjustPitch(boolean up);
}
interface Maintainable
{
    String clean();
    String inspect();
}

class StringedInstrument extends Instrument 
{
    private int numberOfStrings;
    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }
    @Override
    public String play() {
        return "Playing a stringed instrument";
    }
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Strings: " + numberOfStrings;
    }
}

class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType;

    public Guitar(String name, int year, int strings, String guitarType) {
        super(name, year, strings);
        this.guitarType = guitarType;
    }

    @Override
    public String play() {
        return "Playing " + guitarType + " guitar";
    }

    public String tune() {
        return "Tuning the guitar";
    }

    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch" : "Decreasing pitch";
    }

    public String clean() {
        return "Cleaning the guitar";
    }

    public String inspect() {
        return "Inspecting the guitar";
    }
}

class Piano extends Instrument implements Tunable, Maintainable 
{
    private boolean isGrand;

    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }

    @Override
    public String play() {
        return isGrand ? "Playing a grand piano" : "Playing an upright piano";
    }
    public String tune() {
        return "Tuning the piano";
    }

    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch" : "Decreasing pitch";
    }

    public String clean() {
        return "Cleaning the piano";
    }

    public String inspect() {
        return "Inspecting the piano";
    }
}