package expense_manager.service;

import expense_manager.model.SummaryResponse;
import expense_manager.model.Transaction;
import expense_manager.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service //Logic, validations, rules, calculations
public class TransactionService {

    public TransactionService(TransactionRepository transactionRepository)
    {
        this.transactionRepository = transactionRepository;
    }
    //      vvvvvvvv
    //Spring adds the repository by itself when is created
    private final TransactionRepository transactionRepository;

    //Get all saved transactions from the repository
    public List<Transaction> getAllTransactions()
    {
        return transactionRepository.findAll();
    }

    //Saves a new transaction
    public Transaction createTransaction(Transaction transaction)
    {
        //You can NOT create a transaction with amount 0
        if(transaction.getAmount() <= 0)
            throw new IllegalArgumentException("Amount invalid");

        //If the transaction does NOT have a date, give it the current date
        if(transaction.getDate() == null)
            transaction.setDate(LocalDate.now());

        return transactionRepository.save(transaction);
    }

    //Erase a transaction by index
    public void deleteTransaction(Long id)
    {
        //You can NOT delete a transaction that does NOT exist, launch an 404 error if is NOT valid
        if(!transactionRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found!");

        transactionRepository.deleteById(id);
    }

    public Transaction getTransactionById(Long id)
    {
        //Gets one transaction of posible, launch an 404 error if is NOT valid
        return transactionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found!"));
    }

    public SummaryResponse getSummary()
    {
        List<Transaction> all = transactionRepository.findAll();

        int totalIncome = 0;
        int totalExpense = 0;

        //Compare the type of transaction on the list
        for(Transaction t : all)
        {
            //Add income
            if("INCOME".equalsIgnoreCase(t.getType()))
                totalIncome += t.getAmount();
            //Add expense
            else if ("EXPENSE".equalsIgnoreCase(t.getType()))
                totalExpense += t.getAmount();
        }

        //Calculate the total amount of money left
        int currentAmount = totalIncome - totalExpense;

        return new SummaryResponse(currentAmount, totalIncome, totalExpense);
    }
}
