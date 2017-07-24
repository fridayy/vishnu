import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PagedContentComponent } from './paged-content.component';

describe('PagedContentComponent', () => {
  let component: PagedContentComponent;
  let fixture: ComponentFixture<PagedContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PagedContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagedContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
