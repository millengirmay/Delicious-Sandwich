package com.layeredLoveDeli;

public class Display {

        public static void showLogo() {
            System.out.println();
            System.out.println("              🍽️  Welcome To Layered Love Deli  🍽️");
            System.out.println("🥖🥬🧀🥪🍅🍞🍗🫓🥒🧅🌶️🍖🥯🥓🍔🥗🥖🥬🧀🥪🍅🍞🍗🫓🥒🧅🌶️🍖🥯🥓🍔🥗");
            System.out.println("            SAVOR THE FLAVOR IN EVERY BITE 😋❤️\n");

        }

        public static void showMainMenu() {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=* MAIN MENU =*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("1 → 🆕 Start a New Order");
            System.out.println("0 → ❎ Exit");
            System.out.println("👉 Enter 1 to start a new order or 0 to exit: ");
        }

        public static void showOrderOptions() {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*= ORDER MENU =*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("1 → 🥪 Add Sandwich");
            System.out.println("2 → 🥤 Add Drink");
            System.out.println("3 → 🍟 Add Chips");
            System.out.println("4 → 🧾 Checkout Order");
            System.out.println("5 → 🌯 Add Special Sandwich");
            System.out.println("0 → 🚫 Cancel Order");
            System.out.print("👉 Please choose to proceed: ");
        }
    }


