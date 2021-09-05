import { mount } from '@vue/test-utils'
import SkiPicker from '../../src/components/SkiPicker.vue'

global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () => Promise.resolve({ maximumLength: 10, minimumLength: 5, recommendedMaximumLength: 10, recommendedMinimumLength: 5 }),
  })
);

describe('SkiPicker.vue', () => {
    it('Should render SkiPicker', () => {
        const wrapper = mount(SkiPicker);
        expect(wrapper.find(selectors.form).exists()).toBe(true);
    })

    it('Should not show error message on load', () => {
        const wrapper = mount(SkiPicker);
        expect(wrapper.find(selectors.errorContainer).exists()).toBe(false);
    })

    it('Should show error message on submit with no entered values', async () => {
        const wrapper = mount(SkiPicker);

        await wrapper.find(selectors.form).trigger('submit.prevent');

        expect(wrapper.find(selectors.errorContainer).exists()).toBe(true);
    })

    it('Should not show error message on submit with correctly entered values', async () => {
        const wrapper = mount(SkiPicker);

        await wrapper.find(selectors.heightInput).find('input').setValue(100);
        await wrapper.find(selectors.ageInput).find('input').setValue(10);
        const radioButton = wrapper.find(selectors.skiStyleInput).find('input');
        radioButton.element.selected = true;
        await radioButton.trigger('change');

        await wrapper.find(selectors.form).trigger('submit.prevent');

        expect(wrapper.find(selectors.errorContainer).exists()).toBe(false);
    })

    it('Should show result container when result with correctly entered values', async () => {
        const wrapper = mount(SkiPicker);

        await wrapper.find(selectors.heightInput).find('input').setValue(100);
        await wrapper.find(selectors.ageInput).find('input').setValue(10);
        const radioButton = wrapper.find(selectors.skiStyleInput).find('input');
        radioButton.element.selected = true;
        await radioButton.trigger('change');

        await wrapper.find(selectors.form).trigger('submit.prevent');
        await wrapper.vm.$nextTick();

        expect(wrapper.find(selectors.resultContainer).exists()).toBe(true);
    })
})

const selectors = {
    heightInput: '[t-id="SkiPicker-heightInput"]',
    ageInput: '[t-id="SkiPicker-ageInput"]',
    skiStyleInput: '[t-id="SkiPicker-skiStyleInput"]',
    resultContainer: '[t-id="SkiPicker-resultContainer"]',
    errorContainer: '[t-id="SkiPicker-errorContainer"]',
    form: 'form',
}
