import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service'; // 1. Import the Driver

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  userEmail = '';
  userPassword = '';

  // 2. Hire the driver by putting them in the constructor
  constructor(private authService: AuthService) {}

  onLogin() {
    console.log("Sending credentials to the backend...");

    // 3. Hand the data to the driver and 'subscribe' (wait for the package to arrive)
    this.authService.login(this.userEmail, this.userPassword).subscribe({

      // 4. If Spring Boot says "200 OK" and gives us the token:
      next: (token) => {
        console.log("Success! The Guard gave us the Keycard:", token);

        // Save the token inside the browser's permanent memory (localStorage)
        localStorage.setItem('jwt_token', token);

        alert("Login Successful! Check your console.");
      },

      // 5. If Spring Boot says "401 Unauthorized" (wrong password) or "403 Forbidden":
      error: (error) => {
        console.error("Login Failed. Spring Boot blocked us:", error);
        alert("Invalid email or password!");
      }
    });
  }
}
