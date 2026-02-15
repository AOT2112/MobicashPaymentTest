package com.compasplus.mobicashpaymenttest.data

import com.compasplus.mobicashpaymenttest.JsonLoader

internal class PreviewTestData {
    fun prepareTestData() : Map<String?, List<JsonLoader.FaqDataItem>> {
        val data : List<JsonLoader.FaqDataItem> = listOf(
            JsonLoader.FaqDataItem(
                "q1-1",
                "Security",
                "How safe is the Платежи Мобикеш service?",
                "Платежи Мобикеш is extremely secure and has been designed with your security in mind. We have a number of security measures in place. These include:\\n\\nPIN protection. Just like your card and your mobile phone, the app is protected with a four-digit PIN.\\n\\nPIN block. If you have forgotten your PIN you are given three attempts to remember it. If you are still unsuccessful after a 30-minute delay you will be given another three attempts to enter the correct PIN. After this you will be referred to the customer services team so that we can verify that you are you.\\n\\nSecurity questions. If you have set up the security questions and answers (tap on the icon on the righthand corner of the screen and choose the Security questions option), this feature will be offered to you after the first unsuccessful PIN attempt or will automatically kick in after three unsuccessful PIN attempts. If the first security question is answered incorrectly, you will be asked two more questions. If either of these is answered incorrectly, your account will be temporarily blocked until we can verify that you are you.\\n\\nBiometrics. You can use biometric authentication instead of your PIN. Biometric authentication is available for devices that are equipped with the appropriate scanner.\\n\\nAutomatic logout. This app is designed to automatically log you out after a few minutes of inactivity. For your own peace of mind, you can adjust this timeframe as you see fit.\\n\\nUnique identifiers. Both your mobile device and mobile number are linked to your Платежи Мобикеш account and act as unique identifiers. This is to ensure that a fraudster cannot access your account from any other device or using a different mobile number (SIM card).\\n\\nMemPad. MemPad is an easy way to enter your PIN and boasts a non-standard keyboard, making it hard for fraudsters to gain access to your PIN using hacking software to capture keyboard entries.\\n\\nCard details secure storage. For security reasons your card numbers are not stored on your mobile device. Your details will be stored on a secure server in our certified (worldwide Payment Card Industry Data Security Standard compliant) data centre.\\n\\nRetailers / billers / businesses do not see your financial details. No financial information is passed on to retailers / billers / businesses when you make payments with this app.\\n\\n3D Secure. This service uses 3D Secure. 3D Secure (Verified by VISA, MasterCard SecureCode) is an extra layer of security offered to you by your bank when shopping. Each bank has its own 3D Secure verification procedure. When making a payment you will need to follow your bank procedure."
            ),

            JsonLoader.FaqDataItem(
                "q1-2",
                "Security",
                "I lost my mobile device what should I do?",
                "For security reasons your payment method details are not stored on your mobile device and the app is password protected should it fall into the wrong hands. Once you have recovered or replaced your mobile phone, download the app and activate your account."
            ),

            JsonLoader.FaqDataItem(
                "q1-3",
                "Security",
                "What should I do if I suspect unauthorised activity on my Платежи Мобикеш account?",
                "This situation is highly unlikely as your Платежи Мобикеш account is linked to your device and phone number (SIM card). Unlike cards or online shopping accounts, your Платежи Мобикеш account cannot be used without your knowledge on another device.\\n\\nIf you still think someone has accessed your account by using your phone without your permission you need to report this activity immediately. There are several options available to you. If you can, sign in to your Платежи Мобикеш account and change your PIN. Alternatively, you can request a callback or remove your payment methods at any time by either tapping on the Wallet icon on the Dashboard screen and choosing the delete option or tapping on the icon on the righthand corner of the screen and choosing the Remove all payment methods option.\\nOnce the situation has been resolved, you can add a payment method to your account and begin using the service again."
            ),

            JsonLoader.FaqDataItem(
                "q1-4",
                "Security",
                "What do I do if my account has been blocked / suspended?",
                "Your security is our top priority. If we believe that your account might be at risk, we may block it for security reasons. Your account will only be blocked if certain suspicious actions are performed in your app (for example, there were three incorrect attempts to enter your PIN).\\n\\nYou will be notified that your account is blocked / suspended via the app and you will be offered an option to request a callback from a customer service representative. You will also have an option to cancel the process and address the situation at your convenience. In this case, the app will redirect you to the Welcome screen. You will need to press Subscribe / Sign in, enter your phone number and request a callback. When your account is blocked, we will have to speak to you in person so that we will be able to establish that you are you and it is safe to reactivate your account.\\n\\nWe cannot send you an automated reactivation link via email, as some other services choose to do. This is due to the fact that should a fraudster get hold of your phone, they might be able to get access your email and use the link to gain access to your Платежи Мобикеш account. If we speak to you in person, we can ensure your account will always be safe and secure."
            ),

            JsonLoader.FaqDataItem(
                "q2-1",
                "How Платежи Мобикеш works",
                "What is the difference between Subscribe, Activate and Guest Mode?",
                "To get the most benefit from this service and all of the associated advantages, we recommend that you subscribe. Subscribing means that you will have a full Платежи Мобикеш account. Should you choose not to subscribe, there is also a guest checkout option, which lets you pay but only offers the basic features of the Платежи Мобикеш service.\\n\\nThe activate option is available to customers that already have a Платежи Мобикеш account. This is for when, for example, you are reinstalling the app on a new handset or your account has been deactivated / suspended for security reasons."
            ),

            JsonLoader.FaqDataItem(
                "q2-2",
                "How Платежи Мобикеш works",
                "Why can't I receive my verification code?",
                "The most common reason for not receiving an SMS is due to the fact that an incorrect phone number was entered. Please check you have entered the correct number before trying again."
            ),

            JsonLoader.FaqDataItem(
                "q2-3",
                "How Платежи Мобикеш works",
                "How will my contact details be used?",
                "We ask for these details so that we can easily contact you and to quickly identify you when we are resolving any problems you may have. Your mobile phone number is a unique identifier and essential should you request a callback. Your email address will be used to send you important updates about your account and our service. You can also request any reports and copies of paid bills to be sent to your email address."
            ),

            JsonLoader.FaqDataItem(
                "q2-4",
                "How Платежи Мобикеш works",
                "How long is my payment history kept for?",
                "Your payment history is available on the app for three calendar years. If you have any queries or wish to see transactions prior to this timeframe, you will need to check your bank / card statement for the card(s) in question. All Платежи Мобикеш transactions will appear on your card statement as per normal card transactions."
            ),

            JsonLoader.FaqDataItem(
                "q2-5",
                "How Платежи Мобикеш works",
                "When will my transactions appear on my bank statement?",
                "Transactions via Платежи Мобикеш are card-based and will appear on your bank statement in the same timeframe that you could expect normal card transactions from your bank to clear. This can be anything from immediately to a couple of days depending on your card issuer."
            ),

            JsonLoader.FaqDataItem(
                "q3-1",
                "How to pay",
                "How old must I be to use Платежи Мобикеш?",
                "You need to be 16 years of age or older to use Платежи Мобикеш. By agreeing to our Terms of Service, you are also confirming that you are over 16. Please read these terms carefully to make sure that you abide by the legal requirements of using this service."
            ),

            JsonLoader.FaqDataItem(
                "q3-2",
                "How to pay",
                "Where can I pay with Платежи Мобикеш?",
                "You can pay using Платежи Мобикеш wherever you see the Платежи Мобикеш acceptance logo. Should you be in any doubt, you can ask the retailer / biller / business directly. Платежи Мобикеш is a new and exciting service that is being rolled out across the UK, Jordan and a few other countries. The list of retailer / biller / business where Платежи Мобикеш payments are accepted can be found by tapping the Businesses button on the Service Dashboard screen. Платежи Мобикеш designed to pay for goods and services of retailers and businesses, from high street shops, restaurants, market stalls and online retailers, to bill providers (utilities, councils), schools and nurseries, local tradesmen, taxis, charities, clubs and societies, events and many other registered companies that accept payments.\\n\\nPlease note: to use this service you will need access to the Internet (Wi-Fi or mobile data)."
            ),

            JsonLoader.FaqDataItem(
                "q3-3",
                "How to pay",
                "Will I be charged for using the Платежи Мобикеш service?",
                "This app is free to download and we do not charge you for using the Платежи Мобикеш service. Some retailers / billers / businesses may choose to charge you a small surcharge or comfort fee for using Платежи Мобикеш to pay for their goods or services. In this instance, you should be notified before you make a payment. The majority of retailers / billers / businesses will not charge you for using this service. Standard charges set up between you and your bank/card issuer will still apply. Network charges as agreed with your mobile network provider to include data usage may also apply. All text messages that you receive from Платежи Мобикеш are free unless abroad or roaming.\\n\\nTo ensure your transactions are secure when using Платежи Мобикеш, you will need to go through the 3D Secure process as set up by your card issuer. As part of the registration process your card issuer may inform you that your account will be debited one unit of the currency in the account. This is a technical security check only and the transaction will not appear on your account statement. This allows us to verify that your card is not being used fraudulently. Your security is our top priority and as such this is only a test and the money will NOT be taken from you."
            ),

            JsonLoader.FaqDataItem(
                "q3-4",
                "How to pay",
                "How will the retailer / biller / business know I have paid via Платежи Мобикеш?",
                "When you make a payment using Платежи Мобикеш, the bill is marked with a green Paid symbol beneath it.\\n\\nThe retailer / biller / business will immediately receive notification of your payment either in their own app or cash register, or will see your payment on the list of paid bills at the end of a billing period or upon receiving a copy of your payment order depending on the type of company they are and their chosen integration method."
            ),

            JsonLoader.FaqDataItem(
                "q3-5",
                "How to pay",
                "I have entered the wrong bill number and paid the wrong retailer /biller /business. What do I do?",
                "We have a number of safe guards in place to make sure you do not pay the wrong retailer / biller / business when entering the bill by keyboard. However, should this occur we are unable to recall the payment as we are not your bank or the retailer / biller / business; we are facilitating the payment. You may wish to contact your bank to see what options are available to you. Be very careful when entering the bill number. We are not responsible if you make a payment to the wrong retailer / biller / business. Each time you make a payment with the Платежи Мобикеш service you are given the opportunity to review the bill details before you pay. To avoid manual bill entry mistakes, we suggest you use the QR Code or NFC payment options."
            ),

            JsonLoader.FaqDataItem(
                "q3-6",
                "How to pay",
                "What should I do if there is a problem with goods or services, I have paid for using Платежи Мобикеш?",
                "The Платежи Мобикеш service is a payment service. Should you have any issues with the goods or services you have purchased, including delivery, you will need to contact the retailer / biller / business directly."
            ),

            JsonLoader.FaqDataItem(
                "q4-1",
                "Payment methods",
                "Where are my card details stored?",
                "For security reasons your card details are not stored on your mobile device. Your details will be stored on a secure server in our fully certified (PCI DSS compliant) data centre."
            ),

            JsonLoader.FaqDataItem(
                "q4-2",
                "Payment methods",
                "What cards can I link to my Платежи Мобикеш account?",
                "The Платежи Мобикеш service is developed with ease of use in mind. As such, you can link multiple cards to this service. Card types include, debit cards, credit cards, corporate cards and prepaid cards so long as these cards carry the appropriate logo. We are working hard to accept other regional and international card brands and we will keep you updated accordingly."
            ),

            JsonLoader.FaqDataItem(
                "q4-5",
                "Payment methods",
                "My card has expired, what do I do?",
                "Tap on the Wallet icon on the Service Dashboard screen.\\n\\nIn this screen you can view all of the payment methods you have set up to use on Платежи Мобикеш and edit, add or delete cards as you see fit."
            ),

            JsonLoader.FaqDataItem(
                "q4-6",
                "Payment methods",
                "My card was lost or stolen, what do I do?",
                "If your card is lost or stolen, we strongly advise that you contact your bank / card issuer immediately. Once you have a new card, you can update your card details, by tapping on the Wallet icon on the Dashboard screen."
            ),

            JsonLoader.FaqDataItem(
                "q5-1",
                "Account",
                "If I get a new phone number what do I do?",
                "As your mobile number is one of your unique identifiers and acts as your account ID, we need to ascertain that you are you. There are two options available.\\nFirstly, you can link your account to the new number. Sign in to the app, tap on the icon on the top righthand corner of the screen, choose the Change phone number option and follow the on-screen instructions.\\nAlternatively, if your account is relatively new and you haven't set up any preferences you can re-subscribe to this service and set up a new account under your new phone number. If you go for the latter option, we recommend that you unsubscribe your account from your old number first."
            ),

            JsonLoader.FaqDataItem(
                "q5-2",
                "Account",
                "If I get a new phone (handset) what do I do?",
                "As your mobile device is one of your unique identifiers your account can only be linked to one device at a time. This is to ensure that a fraudster cannot access your account from any other device. Should you wish to transfer your account to a new device (for example, if you have upgraded your phone), you will need to reactivate your account. To reactivate your account on the new device, download the app, choose the Subscribe / Sign In in option on the welcome screen and follow a few simple instructions. There is no need to perform any actions on your old device. Starting the reactivation procedure on a new handset automatically deactivates your account on the previous device. Your new phone will be your new unique identifier for your Платежи Мобикеш account. This procedure is only relevant if you have kept the same phone number."
            ),

            JsonLoader.FaqDataItem(
                "q5-3",
                "Account",
                "What do I do if I have forgotten my Платежи Мобикеш PIN?",
                "You have three attempts to enter your PIN correctly, with the option to reset your PIN at any time.\\nIf you exceed three PIN entry attempts and you have previously set up your security questions and answers, you will be randomly asked two of the questions you have set. If both questions are answered correctly, you will have the option to reset your PIN. If either of the questions is answered incorrectly, you will be offered the opportunity to request a callback from a customer service representative.\\n\\nIf you have not previously set up your security questions and answers, after a 30-minute delay you will have a further three attempts to enter your PIN correctly. If you are unsuccessful, you will be offered the opportunity to request a callback from a customer service representative."
            ),

            JsonLoader.FaqDataItem(
                "q5-4",
                "Account",
                "I don't want to use Платежи Мобикеш anymore. Can I just delete the app?",
                "Deleting the app from your mobile phone will only serve to deactivate your account, which can be re-activated by yourself at any time. To close your Платежи Мобикеш account, tap on the icon on the righthand corner of the screen and choose the Unsubscribe option."
            ),

            JsonLoader.FaqDataItem(
                "q99-10",
                null,
                "I've started using the app, but I have some questions that aren't answered here. Where do I go?",
                "Платежи Мобикеш offers comprehensive FAQs. Should you have any questions that are not answered please contact our customer service team via the app by choosing the appropriate option in the Settings or by requesting a callback (tap on the icon on the righthand corner of the screen)."
            ),

            )

        val readyData = data.groupBy(keySelector = { it.Subject })
        return readyData
    }
}