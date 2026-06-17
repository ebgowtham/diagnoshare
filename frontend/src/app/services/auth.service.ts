import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // 1. The exact address of your Spring Boot front desk
  private apiUrl = 'http://localhost:8080/api/users';

  // 2. We inject the HttpClient so the service can use it
  constructor(private http: HttpClient) { }

  // 3. The route the driver takes
  login(email: string, password: string): Observable<any> {
    const body = { email: email, password: password };

    // 4. Drive to /login, drop off the body, and bring back the JWT token
    // (We use responseType: 'text' because your Spring Boot backend returns a raw JWT string, not a JSON object)
    return this.http.post(`${this.apiUrl}/login`, body, { responseType: 'text' });
  }
}
