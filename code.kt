fun main(args: Array<String>)
{
    println("Hellowy, what would you like to do today?")
    homePage()
}

var cart_map = mutableMapOf<Int, String>(1 to "Empty Cart")
var count : Int = 1

fun homePage()
{
    println("================HOME================")
    println("1. Menu")
    println("2. Cart")
    print("Enter corresponding number to continue(0 to exit): ")
    val response : Int = Integer.valueOf(readLine())

    if (response == 1)
    {
        menuPage()
    }
    else if (response == 2)
    {
        cartPage()
    }
    else if (response == 0)
    {
        println("Adios!")
    }
    else
    {
        println("Bzzt! Incorrect response. Back to home page")
        homePage()
    }
}

fun menuPage()
{
    println("================MENU================")
    var menu_map = mapOf<Int, String>(1 to "Item A", 2 to "Item B", 3 to "Item C", 4 to "Item D", 5 to "Item E")
    for(key in menu_map.keys)
    {
        println("$key. ${menu_map.get(key)}")
    }
    print("Enter corresponding item number to add to cart (0 to go back): ")
    val response : Int = Integer.valueOf(readLine())

    if (response == 0)
    {
        homePage()
    }
    else
    {
        var isFound : Boolean = false

        for(key in menu_map.keys)
        {
            if (response == key)
            {
                cart_map[count] = (menu_map[response]).toString()
                count++
                isFound = true
                println("${menu_map.get(response)} has been added to the cart! Continue shopping?")
                print("Enter 1 for yes, 2 for no: " )
                val input : Int = Integer.valueOf(readLine())

                if (input == 1)
                {
                    menuPage()
                }
                else if (input == 2)
                {
                    homePage()
                }
                else 
                {
                    println("Bzzt! Incorrect response. Back to home page")
                    homePage()
                }
                break
            }
        }
        if (!(isFound))
        {
            println("No such item exists")
            menuPage()
        }
    }  
}

fun cartPage()
{
    println("================CART================")
    println("Items in your cart: ")
    
    for(key in cart_map.keys)
    {
        println("$key. ${cart_map.get(key)}")
    }    

    if((cart_map[1] == "Empty Cart"))
    {
        println("You currently have no items in your cart. Press any button to go back ")
        val keyPressed = readLine()
        homePage()
    }
    else
    {
        print("Enter 1 to remove an item, 2 to go back to home page: ")
        val input : Int = Integer.valueOf(readLine())

        if (input == 1)
        {   
            print("Enter number corresponding to the item you want to remove: ")
            val response : Int = Integer.valueOf(readLine())

            var isFound : Boolean = false

            for(key in cart_map.keys)
            {
                if (response == key)
                {
                    isFound = true
                    println("${cart_map.get(response)} has been removed from the cart!")
                    cart_map.remove(response)
                    count--
                    if (count == 1)
                    {
                        cart_map[1] = "Empty Cart"
                    }
                    break
                }
            }

            if (!(isFound))
            {
                println("No such item exists")
                cartPage()
            }

            else
            {
                var i : Int = 1
                for(key in cart_map.keys)
                {
                    cart_map[i] = (cart_map[key]).toString()
                    i++
                    if (i >= count && i != 1)
                    {
                        cart_map.remove(i)
                        break
                    }
                }

                if((cart_map[1] == "Empty Cart"))
                {
                    println("You currently have no items in your cart. Press any button to go back ")
                    val keyPressed = readLine()
                    homePage()
                }

                else
                {
                    println("Do you wish to remove more items?")
                    print("Enter 1 for yes, 2 for no: " )
                    val userInput : Int = Integer.valueOf(readLine())
        
                    if (userInput == 1)
                    {
                        cartPage()
                    }
                    else if (userInput == 2)
                    {
                        homePage()
                    }
                    else 
                    {
                        println("Bzzt! Incorrect response. Back to home page")
                        homePage()
                    }
                }
            }
        }
        else if (input == 2)
        {
            homePage()
        }
        else
        {
            println("Bzzt! Incorrect response")
            cartPage()
        }
    }
}

