import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/booking';
import { BookingserviceService } from '../bookingservice.service';

@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent implements OnInit {

  public allbookings: Booking[] = [];
  userEmail:any;
  constructor(private bookingService: BookingserviceService) {




  }
  ngOnInit(): void {
    this.userEmail = localStorage.getItem('email');
    this.getBooking();
    // console.log(this.allbookings)
    // this.allbookings = [{
    //   bookingDateslot:"22-01-2023",
    //   bookingId:4,
    //   bookingStatus:"available",
    //   groundId:"12",
    //   groundOwnerEmail:"ad@gmail.com",
    //   playerEmail:"anna@gmail.com",
    //   pricePaid:21000,
    //   slotDate:"31-05-2023",
    //   slotId: 21
    // },
    // {
    //   bookingDateslot:"21-01-2023",
    //   bookingId:40,
    //   bookingStatus:"available",
    //   groundId:"1",
    //   groundOwnerEmail:"add@gmail.com",
    //   playerEmail:"annanya@gmail.com",
    //   pricePaid:2100,
    //   slotDate:"3-05-2023",
    //   slotId: 10
    // }];
  }

  getBooking() {
    this.bookingService.getAllBookings(this.userEmail).subscribe(
      (data) => {
        console.log(data);
        this.allbookings = data;

      },
      (error) => {
        console.log("error");
      },
    );
  }


}
