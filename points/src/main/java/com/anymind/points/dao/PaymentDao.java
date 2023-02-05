package com.anymind.points.dao;

import com.anymind.points.entities.ISalesAnalaytics;
import com.anymind.points.entities.Payment;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentDao extends CrudRepository<Payment, String> {
	@Query(" select sum(p.points) as pointsSum, sum(p.finalPrice) as priceSum, date_trunc('hour',p.paymentDate) as dateHour from Payment p where p.paymentDate between ?1 and ?2 \r\n" + 
			"group by date_trunc('hour',p.paymentDate) order by dateHour desc")
	public List<ISalesAnalaytics> getSalesAndPointsByHourAndInterval (Timestamp startDate,Timestamp endDate);
}
