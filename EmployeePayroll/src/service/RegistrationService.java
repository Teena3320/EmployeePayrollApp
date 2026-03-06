package service;

import exceptions.ValidationException;
import domain.Employee;
import domain.UserAccount;
import repository.FileRepository;
import validation.Validator;

import java.io.IOException;

public class RegistrationService {

    public Employee register(String empId,
                             String name,
                             String email,
                             String phone,
                             String username,
                             String password) throws ValidationException, IOException {

        Validator.validateEmpId(empId);
        Validator.validateName(name);
        Validator.validateEmail(email);
        Validator.validatePhone(phone);
        Validator.validateUsername(username);
        Validator.validatePassword(password);

        UserAccount account = new UserAccount(username, password); 
        Employee employee = new Employee(empId, name, email, phone, account);

        new FileRepository().save(employee);

        return employee;
    }
}