import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  reportData: any = null;
  errorMessage: string = '';

  constructor(private dataService: DataService, private router: Router) { }

  ngOnInit() {
    console.log("Dashboard loaded. Requesting patient file...");

    this.dataService.getPatientReport().subscribe({
      next: (data) => {
        console.log("File received!", data);
        this.reportData = data;
      },
      error: (err) => {
        console.error("Failed to fetch report", err);
        this.errorMessage = "Access Denied or Database Error.";
      }
    });
  }
  onLogout() {
    console.log("Terminating secure session...");
    localStorage.removeItem('jwt_token');
    this.router.navigate(['/login']);
  }
}
