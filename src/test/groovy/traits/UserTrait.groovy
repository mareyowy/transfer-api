package groovy.traits

import com.marey.transferapi.user.model.User

trait UserTrait {

    def userList() {
        return [
                [
                   id: 1,
                   name: "Jan Kowalski",
                   address: "ul. Pierwsza 1"
                ] as User,
                [
                   id: 2,
                   name: "Jan Nowak",
                   address: "ul. Druga 2"
                ] as User,
                [
                        id: 3,
                        name: "Krzysztof Testowy",
                        address: "ul. Trzecia 3"
                ] as User
        ] as Set
    }

    def getUser() {
        [
                id: 1L,
                name: "Jan Kowalski",
                address: "ul. Pierwsza 1"
        ] as User
    }
}