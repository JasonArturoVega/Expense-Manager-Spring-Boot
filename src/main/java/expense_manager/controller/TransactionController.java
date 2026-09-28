package expense_manager.controller;

import expense_manager.model.SummaryResponse;
import expense_manager.model.Transaction;
import expense_manager.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Expose the routes of the API
@RestController //This class exposes endpoints: GET, POST, DELETE, etc
@RequestMapping("/transactions")
public class TransactionController {

    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }
    //      vvvvvvvv
    //Spring adds the service by itself when is created
    private final TransactionService transactionService;

    //Get http://localhost:8080/transactions the list of all transactions
    @GetMapping //If someone calls that route with that HTTP method, this function executes.
    public List<Transaction> getAll()
    {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getOneTransaction(@PathVariable Long id)
    {
        //PathVariable takes the id from the url
        return transactionService.getTransactionById(id);
    }

    //Post http://localhost:8080/transactions create a new transaction
    @PostMapping
    public Transaction create(@RequestBody Transaction transaction)
    {
        //RequestBody gets the JSON and transforms it to a class object
        return transactionService.createTransaction(transaction);
    }

    //Delete http://localhost:8080/transactions/1, in other words delete the transaction with id 1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        //PathVariable takes the id from the url
        transactionService.deleteTransaction(id);
        return "Transaction id: " + id + " deleted.";
    }

    @GetMapping("/summary")
    public SummaryResponse summary()
    {
        return transactionService.getSummary();
    }
}
