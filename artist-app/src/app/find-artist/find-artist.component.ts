import { Component, OnInit } from '@angular/core';
import { ArtistApiService } from '../artist-api.service';

@Component({
  selector: 'app-find-artist',
  templateUrl: './find-artist.component.html',
  styleUrls: ['./find-artist.component.css']
})
export class FindArtistComponent implements OnInit {

  service :ArtistApiService;
  searchId :number;
  artist :any;

  constructor(service :ArtistApiService) { 
    this.service = service
    this.searchId = 0;
  }

  ngOnInit(): void {
  }

  onChange() :void {
    this.service.findById(this.searchId).subscribe(data => {
      this.artist = data;
    });
  }

}
