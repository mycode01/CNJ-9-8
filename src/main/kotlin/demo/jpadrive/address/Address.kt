package demo.jpadrive.address

import demo.jpadrive.data.BaseEntity
import javax.persistence.*

@Entity
class Address() : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0L

    var street1: String? = null
    var street2: String? = null
    var state: String? = null
    var city: String? = null
    var country: String? = null
    var zipcode = 0

    @Enumerated(EnumType.STRING)
    var addressType: AddressType? = null

    constructor (street1: String?, street2: String?, state: String?, city: String?, country: String?, addressType: AddressType, zipcode: Int) : this() {
        this.street1 = street1
        this.street2 = street2
        this.state = state
        this.city = city
        this.country = country
        this.zipcode = zipcode
        this.addressType = addressType
    }
}

enum class AddressType {
    SHIPPING, BILLING
}