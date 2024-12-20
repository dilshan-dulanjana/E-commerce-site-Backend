package edu.icet.crm.repository.repo;

import edu.icet.crm.model.Bill;
import edu.icet.crm.model.BillItem;
import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;

public interface CustomersRepository {

    public boolean logingCheck(String email,String password);



    @Transactional
    public HashMap<String, Object> makeBill(Bill bill, List<BillItem> billItems);
}
