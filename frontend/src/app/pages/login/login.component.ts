import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

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


  constructor(private authService: AuthService,private router: Router) { }

  onLogin() {
    console.log("Sending credentials to the backend...");


    this.authService.login(this.userEmail, this.userPassword).subscribe({


      next: (response) => {
        console.log("Spring Boot sent us this response object:", response);

        const cleanToken = response.token;

        if (cleanToken) {
          localStorage.setItem('jwt_token', cleanToken);
          this.router.navigate(['/dashboard']);
        } else {
          alert("Login worked, but Angular couldn't find the token in the response! Check the console.");
        }
      },


      error: (error) => {
        alert("Invalid email or password!");
      }
    });
  }
}
