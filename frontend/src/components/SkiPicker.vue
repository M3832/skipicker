<template>
  <div>
    <form class="container" @submit.prevent="handleSubmit" @click="clearError">
      <h1>Skidlängdskalkylator</h1>
      <NumberInput t-id="SkiPicker-heightInput" label="Längd" id="length" @value-change="handleHeightInput" unit="cm" :required="true" />
      <NumberInput t-id="SkiPicker-ageInput" label="Ålder" id="age" @value-change="handleAgeInput" unit="år" :required="true" />
      <RadioInput t-id="SkiPicker-skiStyleInput" label="Skidstil" :options="skiStyles" @value-change="handleSkiStyleInput" :required="true" />
      <button t-id="SkiPicker-submitButton">Räkna</button>
    </form>

    <div v-if="calculatedSkiLengths" t-id="SkiPicker-resultContainer" class="container">
      <h4>Resultat</h4>
      <p v-if="recommendedSkiLengthsIsASpan">Vi rekommenderar att dina skidor ligger på en längd mellan <b>{{calculatedSkiLengths.recommendedMinimumLength}} och {{calculatedSkiLengths.recommendedMaximumLength}}cm</b>.</p>
      <p v-else>Vi rekommenderar en skidlängd på <b>{{calculatedSkiLengths.recommendedMinimumLength}}cm</b>.</p>
      <p v-if="hasMaximumLength">Tänk på att dina skidor <b>inte får överstiga {{calculatedSkiLengths.maximumLength}}cm</b> med din kombination av stil, längd och ålder.</p>
      <p v-if="hasMinimumLength">Tänk på att dina skidor <b>inte får understiga {{calculatedSkiLengths.minimumLength}}cm</b> med din kombination av stil, längd och ålder.</p>
    </div>

    <div v-if="error" t-id="SkiPicker-errorContainer" class="container error">
      <p>{{errorMessage}}</p>
    </div>
  </div>
</template>

<script>
import NumberInput from './NumberInput.vue';
import RadioInput from './RadioInput.vue';

const skiStyles = [
  {value: 'CLASSIC', label: 'Klassisk'},
  {value: 'FREESTYLE', label: 'Fristil'},
]
const minHeight = 50;
const maxHeight = 250;
const minAge = 0;
const maxAge = 110;

export default {
  name: 'SkiPicker',
  components: {
    NumberInput,
    RadioInput
  },
  data() {
    return {
      error: false,
      errorMessage: '',
      skiStyles: skiStyles,
      selectedSkiStyle: null,
      selectedHeight: null,
      selectedAge: null,
      calculatedSkiLengths: null,
    }
  },
  computed: {
    recommendedSkiLengthsIsASpan() {
      return this.calculatedSkiLengths.recommendedMinimumLength !== this.calculatedSkiLengths.recommendedMaximumLength;
    },
    hasMaximumLength() {
      return this.calculatedSkiLengths.maximumLength !== -1;
    },
    hasMinimumLength() {
      return this.calculatedSkiLengths.minimumLength !== -1;
    }
  },
  methods: {
    async handleSubmit() {
      try {
        this.checkRequired();
        this.checkHeight();
        this.checkAge();

        const response = await fetch(`http://localhost:8080/skilength?skiStyle=${this.selectedSkiStyle}&age=${this.selectedAge}&height=${this.selectedHeight}`);
        this.calculatedSkiLengths = await response.json();
      } catch (error) {
        this.error = true;
        this.errorMessage = error.message;
      }
    },
    handleHeightInput(val) {
      this.selectedHeight = val;
    },
    handleAgeInput(val) {
      this.selectedAge = val;
    },
    handleSkiStyleInput(val) {
      this.selectedSkiStyle = val;
    },
    checkRequired() {
      if(!this.selectedSkiStyle || !this.selectedAge || !this.selectedHeight) {
        throw new Error('Alla fält måste vara ifyllda');
      }
    },
    checkHeight() {
      if(this.selectedHeight < minHeight || this.selectedHeight > maxHeight) {
        throw new Error(`Din längd måste vara mellan ${minHeight} och ${maxHeight}cm`);
      }
    },
    checkAge() {
      if(this.selectedAge < minAge || this.selectedAge > maxAge) {
        throw new Error(`Din ålder måste vara mellan ${minAge} och ${maxAge}`);
      }
    },
    clearError() {
      this.error = false;
      this.errorMessage = '';
    }
  },
}
</script>

<style scoped>
  .container {
    min-width: 200px;
    max-width: 350px;
    width: 100%;
    margin: 5px auto;
    background-color: white;
    padding: 20px;
    border-radius: 20px;
    box-shadow: 0px 0px 12px 0px #010b4082;
  }

  .error {
    color: red;
    border: 1px solid red;
  }

  .error p {
    margin: 0;
  }
</style>
