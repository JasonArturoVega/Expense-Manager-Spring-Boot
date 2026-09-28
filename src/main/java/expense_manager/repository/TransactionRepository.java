package expense_manager.repository;

import expense_manager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Ui that allow you to save, search and delete thing in the database
//Spring implement things automatically

@Repository //It handles data access
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //                                                        ||           ||
    //Allow you to create a repository that works with Transactions and a number (ID)
    //This already have methods like save(), findAll(), findById(), deleteById() and more
}
