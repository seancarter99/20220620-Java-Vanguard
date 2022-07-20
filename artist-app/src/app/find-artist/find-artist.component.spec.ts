import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindArtistComponent } from './find-artist.component';

describe('FindArtistComponent', () => {
  let component: FindArtistComponent;
  let fixture: ComponentFixture<FindArtistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindArtistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindArtistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
