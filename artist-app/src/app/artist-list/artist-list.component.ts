import { Component, OnInit } from '@angular/core';
import { ArtistApiService } from '../artist-api.service';

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrls: ['./artist-list.component.css']
})
export class ArtistListComponent implements OnInit {

  service :ArtistApiService;
  artists :Array<any> = [];

  constructor(service :ArtistApiService) { 
    this.service = service
  }

  ngOnInit(): void {
    this.refreshData();
    setInterval(() => {
      this.refreshData(); 
    }, 5000);
  }

  refreshData() :void {
    this.service.findAll().subscribe(data => {
      this.artists = data;
      console.log('artist data refreshed')
    });
  }

}
