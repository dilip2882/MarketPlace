<div align="center">

<img src="https://github.com/vishal2376/git-coach/assets/logo.p" width="100px"/>

# **MarketPlace**

A modern Android marketplace app that connects buyers and sellers, built with Java and Firebase.

<br/>

<img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black"/>

<br/>
<br/>

</div>

## Features

- **User Authentication**
  - Secure Firebase Authentication
  - Email and Password login
  - User profile management with profile pictures
  - Password reset functionality

- **Product Management**
  - Easy product listing with images
  - Multiple product categories
  - Product search functionality
  - Real-time product updates using Firebase

- **Shopping Features**
  - Intuitive shopping cart
  - Favorites/Wishlist
  - Product details view
  - Category-wise browsing

- **User Interface**
  - Material Design components
  - Smooth navigation using Navigation Component
  - Responsive grid layouts
  - Custom circular profile images
  - Clean and modern UI

## Demo Video

https://github.com/user-attachments/assets/fbc1e14b-a422-4ee6-a9af-d614e19af3fa

## Screenshots

| <img src="assets/sign_in.png" width="200px"> | <img src="assets/sign_up.png" width="200px"> | <img src="assets/Home Screen.png" width="200px"> | <img src="assets/my account.png" width="200px"> |
|---|---|---|---|
| Sign In | Sign Up | Home Screen | My Account |
| <img src="assets/product.png" width="200px"> | <img src="assets/product2.png" width="200px"> | <img src="assets/cart.png" width="200px"> | <img src="assets/my wishliist.png" width="200px"> |
| Product View | Product Details | Shopping Cart | My Wishlist |

**Additional Features:**

| <img src="assets/my orders.png" width="200px"> | <img src="assets/order details.png" width="200px"> | <img src="assets/my rewards.png" width="200px"> | <img src="assets/my addresses.png" width="200px"> |
|---|---|---|---|
| My Orders | Order Details | My Rewards | My Addresses |

## Tech Stack

- **Language**: Java
- **Platform**: Android
- **Backend**: Firebase
  - Firebase Authentication
  - Cloud Firestore
  - Firebase Analytics
- **UI Components**:
  - Material Design
  - ConstraintLayout
  - Navigation Component
  - CircleImageView
  - GridLayout

## Getting Started

### Prerequisites

- Android Studio
- JDK 11 or higher
- Android SDK
- Google Play Services
- Firebase Account

### Installation

1. Clone the repository
```bash
git clone https://github.com/dilip2882/marketplace.git
```

2. Open project in Android Studio

3. Set up Firebase:
   - Create a new Firebase project
   - Add your Android app to Firebase project
   - Download `google-services.json` and place it in the app directory
   - Enable Authentication and Firestore in Firebase Console

4. Build and run the project

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern and uses:
- LiveData for observable data holders
- ViewModel for UI-related data handling
- Navigation Component for fragment navigation
- Firebase for backend services

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



