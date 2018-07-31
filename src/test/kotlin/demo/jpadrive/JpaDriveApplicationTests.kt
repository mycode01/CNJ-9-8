package demo.jpadrive

import com.mysql.jdbc.AssertionFailedException
import demo.jpadrive.account.Account
import demo.jpadrive.address.Address
import demo.jpadrive.address.AddressType
import demo.jpadrive.creditcard.CreditCard
import demo.jpadrive.creditcard.CreditCardType
import demo.jpadrive.customer.Customer
import demo.jpadrive.customer.CustomerRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ActiveProfiles(profiles = ["test"])
@SpringBootTest
class JpaDriveApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Test
    fun customerTest() {
        var account = Account("12345")
        var customer = Customer("Jane", "Doe", "jane.doe@gmail.com", account)
        var creditCard = CreditCard("1234567890", CreditCardType.VISA)
        customer.account!!.creditCards.add(creditCard)

        var street1 = "1600 Pennsylvania Ave NW"
        var address = Address(street1, null, "DC", "Washington", "United States", AddressType.SHIPPING, 20500)
        customer.account!!.addresses.add(address)


        customer = customerRepository.save(customer)
        var persistedResult = customerRepository.findById(customer.id).get()
        Assert.assertNotNull(persistedResult.account)
        Assert.assertNotNull(persistedResult.createdAt)
        Assert.assertNotNull(persistedResult.lastModified)

        Assert.assertTrue(persistedResult.account!!.addresses.stream().anyMatch { it.street1.equals(street1, ignoreCase = true) })

        customerRepository.findByEmailContaining(customer.email).orElseThrow {
            AssertionFailedException(RuntimeException("theres supposed to be a matching record!"))
        }

    }

}
