<template>
  <div class="inputContainer">
    <fieldset>
      <legend :class="required && 'required'"> {{label}} </legend>
      <div v-for="row in options" :key="row.value">
        <input type="radio" :id="row.value" :key="row.value" @change="handleChange" :value="row.value" v-model="inputValue"/>
        <label :for="row.value">{{row.label}}</label>
      </div>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: 'RadioInput',
  props: {
    options: {
      type: Array,
    },
    label: {
      type: String,
    },
    required: {
      type: Boolean,
    }
  },
  data() {
    return {
      inputValue: '',
    }
  },
  methods: {
    handleChange(event) {
      this.$emit('value-change', event.target.value);
    }
  }
}
</script>

<style scoped>
  input {
    margin-top: 10px;
  }

  fieldset {
    border: none;
    margin: 0;
    margin-inline: 0;
    padding-block: 0;
    padding-inline: 0;
  }

  legend {
    display: block;
    font-weight: bold;
  }

  .inputContainer {
    margin-top: 1.4rem;
  }
</style>
