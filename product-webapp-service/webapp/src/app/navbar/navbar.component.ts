import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import th from '@mobiscroll/angular/dist/js/i18n/th';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  role: any;
  ngOnInit(): void {
    this.role = localStorage.getItem('role');
  }
  constructor(private router: Router) { }
  signOut() {
    localStorage.clear();
    this.router.navigate(['/'])
  }
  isOwner(): boolean {
    if (String(this.role) == "Owner") {
      return true;
    }
    return false;
  }
  navigateToBooking(){
    this.router.navigate(["/navbar/bookings"])
  }
  navigateToAddground(){
    this.router.navigate(["/navbar/addground"])
  }
}
