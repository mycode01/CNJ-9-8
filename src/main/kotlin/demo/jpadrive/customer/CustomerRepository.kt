package demo.jpadrive.customer

import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface CustomerRepository : PagingAndSortingRepository<Customer, Long> {
    fun findByEmailContaining(email: String): Optional<Customer>
}