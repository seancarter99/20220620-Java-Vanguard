import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveArtistComponent } from './save-artist.component';

describe('SaveArtistComponent', () => {
  let component: SaveArtistComponent;
  let fixture: ComponentFixture<SaveArtistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveArtistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveArtistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
