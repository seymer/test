import java.util.Arrays;

public class BookTitlesGen {
    public static final String[] technologies = new String[] {
            "AJAX", "EJB3", "JSF", "Web Services"
    };

    public static final String[] templates = new String[] {
            "XXX in Action", "Professional XXX",
            "Effective XXX", "Master XXX",
            "XXX Definitive Guide", "Core XXX",
            "XXX Cookbook", "XXX Bible",
            "Head First XXX", "XXX Best Practice",
            "A Developer's Guide to XXX",
            "XXX Unleashed", "XXX for Dummies",
    };

    public static void main(String[] args) {
        genBookTitles();
    }

    private static void genBookTitles() {
        for (String technology : technologies) {
            String banner = "Best Seller Books for " + technology;
            char[] line = new char[banner.length()];
            Arrays.fill(line, '=');
            System.out.println(banner);
            System.out.println(line);
            for (String template : templates) {
                String title = template.replaceAll("XXX", technology);
                System.out.println(title);
            }
            System.out.println("");
        }
    }
}
