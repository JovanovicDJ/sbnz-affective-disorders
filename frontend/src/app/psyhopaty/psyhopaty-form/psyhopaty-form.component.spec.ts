import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PsyhopatyFormComponent } from './psyhopaty-form.component';

describe('PsyhopatyFormComponent', () => {
  let component: PsyhopatyFormComponent;
  let fixture: ComponentFixture<PsyhopatyFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PsyhopatyFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PsyhopatyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
