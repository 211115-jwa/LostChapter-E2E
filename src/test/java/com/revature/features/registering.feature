Feature: Registering

# TEST-8
Scenario Outline: Regisering with valid information (positive test)
Given I am at the signup page
When I type in a signup username of <username>
And I type in the signup password  <password>
And I type in an signup email of <email>
And I type in a signup first name of <firstname>
And I type in a signup last name of <lastname>
And I type in a signup age of <age>
And I type in a birthday of <birthday>
And I type in an address of <address>
And I select a signup role of <role>
And I click the signup button
Then I should be see a success message saying you have successfully signed up

Examples:
| username         | password   | email                 | firstname | lastname     | age  | role       |  birthday    | address              |
| "unique"    | "password" | "unique" | "John"    | "Doe"        | "25" | "Customer" | "10/03/1996" | "1024 Downtown Road" |  
| "unique" | "wordpass" | "unique"     | "Mike"    | "Dingeldein" | "44" | "Admin"    | "01/05/1985" | "9610 Uptown Road"   |



# TEST-9 through 25
Scenario Outline: Regisering with invalid or missing information (negative test)
Given I am at the signup page
When I type in a signup username of <username>
And I type in the signup password  <password>
And I type in an signup email of <email>
And I type in a signup first name of <firstname>
And I type in a signup last name of <lastname>
And I type in a signup age of <age>
And I type in a birthday of <birthday>
And I type in an address of <address>
And I select a signup role of <role>
And I click the signup button
Then I should see a signup error message of <error>

Examples:
| username        | password   | email                 | firstname | lastname | age  | role       | birthday | address |error                                |	
| ""              | "password" | "unique" | "John"    | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" | "username cannot be blank." |
| "unique"   | ""         | "unique" | "John"    | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"password cannot be blank." |
| "unique"   | "password" | ""                    | "John"    | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"email cannot be blank." |
| "unique"   | "password" | "unique" | ""        | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"firstName cannot be blank." |
| "unique"   | "password" | "unique" | "John"    | ""       | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"lastName cannot be blank." |
| "unique"   | "password" | "unique" | "John"    | "Doe"    | ""   | "Customer" | "10/03/1996" | "1095 downtown road" |"Age cannot be less than 5 or greater than 125" |
| "unique"   | "password" | "unique" | "John"   | "Doe"    | "25" | ""         | "10/03/1996" | "1095 downtown road" |"role cannot be blank." |
| "username"   | "password" | "unique"  | "John"    | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Username already exist." |
| "unique" | "password" | "test@gmail.com" | "John"    | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Email already exist." |
| "unique"   | "password" | "unique" | "John"    | "Doe"    | "-1" | "Customer" | "10/03/1996" | "1095 downtown road" |"Age cannot be less than 5 or greater than 125" |
| "unique"   | "password" | "unique" | "John"    | "Doe"    | "126" | "Customer" | "10/03/1996" | "1095 downtown road" |"Age cannot be less than 5 or greater than 125" |
| "unique"   | "password" | "invalid email"  | "John"    | "Doe"    | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Invalid Email." |
| "unique"   | "password" | "unique" | "gwpwgfuktxgakkfxxxujuqyjheujbwvjrarpmburgvxjcfvxizabrwbgazdmzwikifbhatutfgpzmbhmjegvrhxzphvwmqxuduknwznvugikuzbxrkkqwwwpiajmvukjanhbgyibpuztmxzbzdzezdvbwykpfgvdbcwqminjqmipbnjjkahngymuuzgenkbharxwrajkzjiverczpftdvmgcdcipkzxtnypwrqczjxdugbggrerhxvtyrhhmcubnimevrdqyjqmffiwezxrezvunrfhwucrqaanxitqgnhem" | "Doe" | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Character lengths shouldn't extend over 255 characters" |
| "unique"   | "password" | "unique" | "John"    | "gwpwgfuktxgakkfxxxujuqyjheujbwvjrarpmburgvxjcfvxizabrwbgazdmzwikifbhatutfgpzmbhmjegvrhxzphvwmqxuduknwznvugikuzbxrkkqwwwpiajmvukjanhbgyibpuztmxzbzdzezdvbwykpfgvdbcwqminjqmipbnjjkahngymuuzgenkbharxwrajkzjiverczpftdvmgcdcipkzxtnypwrqczjxdugbggrerhxvtyrhhmcubnimevrdqyjqmffiwezxrezvunrfhwucrqaanxitqgnhem" | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Character lengths shouldn't extend over 255 characters" |
| "unique"  | "password" | "gwpwgfuktxgakkfxxxujuqyjheujbwvjrarpmburgvxjcfvxizabrwbgazdmzwikifbhatutfgpzmbhmjegvrhxzphvwmqxuduknwznvugikuzbxrkkqwwwpiajmvukjanhbgyibpuztmxzbzdzezdvbwykpfgvdbcwqminjqmipbnjjkahngymuuzgenkbharxwrajkzjiverczpftdvmgcdcipkzxtnypwrqczjxdugbggrerhxvtyrhhmcubnimevrdqyjqmffiwezxrezvunrfhwucrqaanxitqgnhem@johndoe.com" | "John" | "Doe" | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Character lengths shouldn't extend over 255 characters" |
| "gwpwgfuktxgakkfxxxujuqyjheujbwvjrarpmburgvxjcfvxizabrwbgazdmzwikifbhatutfgpzmbhmjegvrhxzphvwmqxuduknwznvugikuzbxrkkqwwwpiajmvukjanhbgyibpuztmxzbzdzezdvbwykpfgvdbcwqminjqmipbnjjkahngymuuzgenkbharxwrajkzjiverczpftdvmgcdcipkzxtnypwrqczjxdugbggrerhxvtyrhhmcubnimevrdqyjqmffiwezxrezvunrfhwucrqaanxitqgnhem" | "password" | "unique" | "John" | "Doe" | "25" | "Customer" | "10/03/1996" | "1095 downtown road" |"Character lengths shouldn't extend over 255 characters" |
| "unique"   | "password" | "unique" | "John" | "Doe" | "abc" | "Customer" | "10/03/1996" |  "1095 downtown road" |"Age cannot be less than 5 or greater than 125" |
| "unique" | "password" | "unique" | "John" | "Doe" | "25" | "Customer" | "" | "1095 downtown Road" | "birthday cannot be blank." |
| "unique" | "password" | "unique" | "John" | "Doe" | "25" | "Customer" | "10/03/1996" | "" | "address cannot be blank." | 
| "unique" | "password" | "unique" | "John" | "Doe" | "25" | "Customer" | "101231/51245/126932123" | "1095 downtown road" | "birthdate is invalid format" | 

