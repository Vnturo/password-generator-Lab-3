# Password Generator

## Installation & Build

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Vnturo/password-generator-Lab-3
   cd password-generator
   ```

2. **Build the project using Maven:**
```bash
mvn clean package
```

## Generate a default password (8 characters)

   ```bash
   java -jar target/password-generator-1.0-SNAPSHOT.jar
   ```
## Generate a password with a specific length (Example 16 Char)
```bash
java -jar target/password-generator-1.0-SNAPSHOT.jar -l 16
```

## Generate a password with a specific characters:
```bash
java -jar target/password-generator-1.0-SNAPSHOT.jar -l 16 -s
```

## View the help menu
```bash
java -jar target/password-generator-1.0-SNAPSHOT.jar -h
```

