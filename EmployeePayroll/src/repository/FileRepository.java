package repository;

import domain.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileRepository {

    public void save(Employee employee) throws IOException {
        String fileName = "employee_data.txt";
        Path file = Path.of(fileName);

        String content = employee.toString() + System.lineSeparator();

        Files.writeString(
                file,
                content,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND 
        );
    }
}