package br.com.fabio.hospital.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/* @RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/path1")
*/
public class EmployeeController {
  /*  @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Employee not present for the id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setLname(employeeDetails.getLname());
        employee.setFname(employeeDetails.getFname());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

   */
}