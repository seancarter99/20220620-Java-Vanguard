package com.skillstorm.demo.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional // Adds @Transactional to all methods of this class
// @Transactional says that if any error/exception is thrown during execution. Changes are rolled back
// If the function exits normally (no exception thrown) then the transaction is committed
// Adds @AfterThrowing advice that monitors your transaction and basically says conn.rollback if an error occurs
// Adds @AfterReturing advice that monitors if it returns successfully. Basically says conn.commit
public class PetServiceImpl implements PetService {

}
