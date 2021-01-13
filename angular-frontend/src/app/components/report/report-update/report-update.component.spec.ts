import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportUpdateComponent } from './report-update.component';

describe('ReportUpdateComponent', () => {
  let component: ReportUpdateComponent;
  let fixture: ComponentFixture<ReportUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
