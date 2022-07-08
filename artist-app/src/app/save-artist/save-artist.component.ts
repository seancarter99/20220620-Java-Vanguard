import { Component, OnInit } from '@angular/core';
import { ArtistApiService } from '../artist-api.service';

@Component({
  selector: 'app-save-artist',
  templateUrl: './save-artist.component.html',
  styleUrls: ['./save-artist.component.css']
})
export class SaveArtistComponent implements OnInit {

  service :ArtistApiService;
  artist :any = {}

  constructor(service :ArtistApiService) { 
    this.service = service
  }

  ngOnInit(): void {
  }

  submit(artist: any) :void{
    this.service.save(artist).subscribe(resp => {
      console.log(resp)
    })
  }
}
