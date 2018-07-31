package demo.jpadrive.creditcard

import demo.jpadrive.data.BaseEntity
import javax.persistence.*

@Entity
class CreditCard() : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0L

    var number: String? = null

    @Enumerated(EnumType.STRING)
    var type: CreditCardType? = null

    constructor(number: String, type: CreditCardType) : this() {
        this.number = number
        this.type = type
    }

}

enum class CreditCardType {
    VISA, MASTERCARD, AMERICAN_EXPRESS
}