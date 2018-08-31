package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.zycus.entity.Account;
import com.zycus.entity.FacilityTransaction;

@Component
public class AccountDAO extends GenericDAO{

		public double fetchBalance(int accNo) {
			String jpql = "select a.balance from Account a where a.accNo = :accNo";
			Query query = entityManager.createQuery(jpql); //JPQL
			query.setParameter("accNo", accNo); //Substitute :accNo with actual value
			return (Double) query.getSingleResult();		
		}
		
		public List<FacilityTransaction> listminiStatements(int accNo) {
			String jpql = "select tx from FacilityTransaction tx "
					+ "where tx.account.accNo = :accNo "
					+ "order by tx.txdate DESC";
		
			Query query = entityManager.createQuery(jpql); //JPQL
			query.setParameter("accNo", accNo);
			query.setMaxResults(3);
			return query.getResultList();
		}
		
		public List<Account> fetchAccountsByTransAmt(double amount) {
			String jpql = "select distinct acc from Account acc join acc.transaction tx where tx.amount >= :amt ";		
			Query query = entityManager.createQuery(jpql); //JPQL
			query.setParameter("amt", amount);
			return query.getResultList();
		}
		
		public List<Account> fetchAccountsByHighestTransactionAmount() {
			String jpql = "select distinct acc from Account acc join acc.transaction tx where tx.amount = (select MAX(amount) from FacilityTransaction) ";		
			Query query = entityManager.createQuery(jpql); //JPQL
			return query.getResultList();
		}
		
		
		
		
}
