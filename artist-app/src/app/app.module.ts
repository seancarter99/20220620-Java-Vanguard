import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArtistListComponent } from './artist-list/artist-list.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FindArtistComponent } from './find-artist/find-artist.component';
import { SaveArtistComponent } from './save-artist/save-artist.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtistListComponent,
    FindArtistComponent,
    SaveArtistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
