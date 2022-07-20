import { TestBed } from '@angular/core/testing';

import { ArtistApiService } from './artist-api.service';

describe('ArtistApiService', () => {
  let service: ArtistApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArtistApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
