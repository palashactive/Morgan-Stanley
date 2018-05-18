package com.ms.interview.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.interview.entity.Billing;
import com.ms.interview.entity.BillingId;
import com.ms.interview.entity.Invoice;
import com.ms.interview.entity.MedicineData;
import com.ms.interview.repository.BillingRepository;
import com.ms.interview.service.BillingService;
import com.ms.interview.service.InvoiceService;
import com.ms.interview.service.MedicineDataService;

@Controller
@RequestMapping(path = "/test") // This means URL's start with /test (after Application path)
public class MainController {

	@Autowired
	MedicineDataService medicineDataService;

	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	BillingService billingService;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewMedicine(@RequestBody MedicineData medicineData) {

		MedicineData savedMedicine = medicineDataService.saveMedicine(medicineData);
		if (savedMedicine != null)
			return "Saved";
		else
			return "Error";
	}

	@PostMapping(path = "/buy")
	public @ResponseBody Invoice buyMedicine(@RequestBody List<MedicineData> buyMedicineData) {

		List<Billing> medicineBilling = new ArrayList<>();
		double billingAmt = 0;
		boolean buySuccess = false;
		List<MedicineData> updatedMedicineDataList = new ArrayList<>();
		for (MedicineData medData : buyMedicineData) {

			MedicineData medicineDataDB = null;
			medicineDataDB = medicineDataService.getMedicineByBrandName(medData);

			if (medicineDataDB != null) {

				if (medicineDataDB.getQuantity() >= medData.getQuantity()) {
					buySuccess = true;
					medicineDataDB.setQuantity(medicineDataDB.getQuantity() - medData.getQuantity());
					billingAmt += medData.getQuantity() * medicineDataDB.getPrice();
					updatedMedicineDataList.add(medicineDataDB);

					Billing billing = new Billing();
					billing.setBillingId(new BillingId("", medicineDataDB.getId()));
					billing.setQuantity(medData.getQuantity());
					medicineBilling.add(billing);

				} else {
					updatedMedicineDataList.clear();
					buySuccess = false;
					break;
				}
			} else {
				updatedMedicineDataList.clear();
				buySuccess = false;
				break;
			}
		}

		if (buySuccess) {

			Invoice invoice = new Invoice();
			invoice.setInvoiceNo(UUID.randomUUID().toString());
			invoice.setInvoiceDate(new Date());
			invoice.setBillingAmount(billingAmt);
			
			medicineBilling.stream().forEach(bill->{
				
				BillingId billId = bill.getBillingId();
				billId.setInvoiceNo(invoice.getInvoiceNo());
				bill.setBillingId(billId);
			});
			//invoice.setMedicineBilling(medicineBilling);
			
			invoiceService.saveInvoice(invoice);
			billingService.saveBill(medicineBilling);
			medicineDataService.saveAll(updatedMedicineDataList);
			
			return invoice;
		} else {
			return null;
		}
	}

	@PostMapping(path = "/setup")
	public @ResponseBody Iterable<MedicineData> setup(@RequestBody List<MedicineData> setupData) {

		return medicineDataService.saveAll(setupData);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<MedicineData> getAllMedicines() {
		return medicineDataService.getAllMedicine();
	}
	
	@GetMapping(path = "/getBillingHistory")
	public @ResponseBody Iterable<Billing> getAllBills(@RequestParam String invoiceNo) {
		return billingService.getBillingHistory(invoiceNo);
	}

	@GetMapping(path = "/getMedicineByName")
	public @ResponseBody List<MedicineData> getMedicinesByName(@RequestParam String name) {
		return medicineDataService.getMedicines(name, "Name");
	}

	@GetMapping(path = "/getMedicineByGenericName")
	public @ResponseBody List<MedicineData> getMedicinesByGenericName(@RequestParam String genericName) {
		return medicineDataService.getMedicines(genericName, "GenericName");
	}

	@GetMapping(path = "/getMedicineByCategory")
	public @ResponseBody List<MedicineData> getMedicinesByCategory(@RequestParam String category) {
		return medicineDataService.getMedicines(category, "Category");
	}
}
