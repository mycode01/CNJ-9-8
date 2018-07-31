package demo.jpadrive.account

import org.springframework.data.repository.PagingAndSortingRepository

interface AccountRepository:PagingAndSortingRepository<Account, Long>