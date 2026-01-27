package uk.ac.gold.vrosa003;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import uk.ac.gold.vrosa003.utils.Generator;

public class PasswordApp {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("l", "length", true, "Length of the password (default 8)");
        options.addOption("h", "help", false, "Print this help message");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        int passwordLength = 8; // Default

        try {
            CommandLine cmd = parser.parse(options, args);

            // 1. Handle Help
            if (cmd.hasOption("h")) {
                formatter.printHelp("PasswordApp", options);
                System.exit(0);
            }

            // 2. Check for -l flag
            if (cmd.hasOption("l")) {
                try {
                    passwordLength = Integer.parseInt(cmd.getOptionValue("l"));
                } catch (NumberFormatException e) {
                    System.err.println("Length must be an integer.");
                    System.exit(1);
                }
            }
            // 3. NEW: Check for a plain number (arguments without a flag)
            // This fixes the issue where "java ... 3" was ignored
            else if (cmd.getArgs().length > 0) {
                try {
                    passwordLength = Integer.parseInt(cmd.getArgs()[0]);
                } catch (NumberFormatException e) {
                    System.err.println("Argument " + cmd.getArgs()[0] + " must be an integer.");
                    System.exit(1);
                }
            }

            // 4. Generate Password
            Generator generator = new Generator();
            String password = generator.generate(passwordLength);

            System.out.println("--------------------------------");
            System.out.println("Generated Password: " + password);
            System.out.println("--------------------------------");

        } catch (ParseException e) {
            System.err.println("Error parsing arguments: " + e.getMessage());
            formatter.printHelp("PasswordApp", options);
            System.exit(1);
        }
    }
}