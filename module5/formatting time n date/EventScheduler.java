public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;

    public EventScheduler() {
        events = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Event Scheduler ===");
            System.out.println("1. Add Event");
            System.out.println("2. Display All Events");
            System.out.println("3. Show Time Until Event");
            System.out.println("4. Convert Event Time");
            System.out.println("5. Find Upcoming Events");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addEvent(); break;
                case 2: displayAllEvents(); break;
                case 3: showTimeUntilEvent(); break;
                case 4: convertEventTime(); break;
                case 5: findUpcomingEvents(); break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid!");
            }
        }
    }
    private void addEvent() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Date & Time (yyyy-MM-dd HH:mm): ");
            String input = scanner.nextLine();

            System.out.print("Timezone (e.g. Asia/Dhaka): ");
            String zone = scanner.nextLine();

            System.out.print("Duration hours: ");
            long hours = Long.parseLong(scanner.nextLine());

            LocalDateTime ldt = LocalDateTime.parse(input,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of(zone));
            Duration duration = Duration.ofHours(hours);

            events.add(new Event(name, zdt, duration));
            System.out.println("Event added!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
    private void displayAllEvents() {
        System.out.print("Enter format (e.g. dd/MM/yyyy HH:mm): ");
        String format = scanner.nextLine();

        for (Event e : events) {
            System.out.println(e.display(format));
        }
    }
    private void showTimeUntilEvent() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println(i + ": " + events.get(i).getName());
        }

        System.out.print("Select event: ");
        int index = Integer.parseInt(scanner.nextLine());

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime eventTime = events.get(index).getDateTime();

        Duration diff = Duration.between(now, eventTime);

        System.out.println("Time remaining: " + diff.toHours() + " hours");
    }
    private void convertEventTime() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println(i + ": " + events.get(i).getName());
        }

        System.out.print("Select event: ");
        int index = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new timezone: ");
        String zone = scanner.nextLine();

        ZonedDateTime newTime = events.get(index)
                .getDateTime()
                .withZoneSameInstant(ZoneId.of(zone));

        System.out.println("Converted Time: " + newTime);
    }
    private void findUpcomingEvents() {
        System.out.print("Enter days: ");
        int days = Integer.parseInt(scanner.nextLine());

        ZonedDateTime now = ZonedDateTime.now();

        for (Event e : events) {
            long diff = ChronoUnit.DAYS.between(now, e.getDateTime());
            if (diff >= 0 && diff <= days) {
                System.out.println(e.getName() + " coming in " + diff + " days");
            }
        }
    }

    public static void main(String[] args) {
        new EventScheduler().run();
    }
}