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
        // Enhancement option added to the CLI
        options.addOption("s", "special", false, "Include special characters (!@#$%^&*)");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        int passwordLength = 8; // Default

        try {
            CommandLine cmd = parser.parse(options, args);

            // Handle Help
            if (cmd.hasOption("h")) {
                formatter.printHelp("PasswordApp", options);
                System.exit(0);
            }

            // Check for -l flag
            if (cmd.hasOption("l")) {
                try {
                    passwordLength = Integer.parseInt(cmd.getOptionValue("l"));
                } catch (NumberFormatException e) {
                    System.err.println("Length must be an integer.");
                    System.exit(1);
                }
            }
            // Check for a plain number (arguments without a flag)
            else if (cmd.getArgs().length > 0) {
                try {
                    passwordLength = Integer.parseInt(cmd.getArgs()[0]);
                } catch (NumberFormatException e) {
                    System.err.println("Argument " + cmd.getArgs()[0] + " must be an integer.");
                    System.exit(1);
                }
            }

            // Check if the user wants special characters
            boolean useSpecial = cmd.hasOption("s");

            // Generate Password (now passing the useSpecial flag)
            Generator generator = new Generator();
            String password = generator.generate(passwordLength, useSpecial);

            System.out.println("Generated Password: " + password);

        } catch (ParseException e) {
            System.err.println("Error parsing arguments: " + e.getMessage());
            formatter.printHelp("PasswordApp", options);
            System.exit(1);
        }
    }
}