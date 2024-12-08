import { Component, OnInit } from '@angular/core';
import { GroundService } from '../services/ground.service';
import { Ground } from '../model/ground';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ground-list',
  templateUrl: './ground-list.component.html',
  styleUrls: ['./ground-list.component.css'],
})
export class GroundListComponent implements OnInit {
  grounds: Ground[] = [];

  constructor(private groundService: GroundService, private router: Router) {}

  ngOnInit(): void {
    this.groundService.getAllGrounds().subscribe((data) => {
      this.grounds = data;
    });
  }
  viewDetails(groundId?: string) {
    this.router.navigate(['/arena-details', groundId]);
  }

  public getImageUrl(groundId?: string): string {
    return this.groundService.getGroundImageUrl(groundId);
  }

}
