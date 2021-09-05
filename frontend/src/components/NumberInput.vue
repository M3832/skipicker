<template>
  <div class="inputContainer">
    <label :for="id" :class="required && 'required'">{{label}}</label>
    <input :id="id" type="number" @input="handleInput"/>
    <span class="unit">{{unit}}</span>
  </div>
</template>

<script>
export default {
  name: 'NumberInput',
  props: {
    id: {
      type: String,
    },
    label: {
      type: String,
    },
    value: {
      type: Number,
    },
    unit: {
      type: String,
    },
    required: {
      type: Boolean,
    }
  },
  methods: {
    handleInput(event) {
      this.$emit('value-change', event.target.value);
    }
  }
}
</script>

<style scoped>
  label {
    display: block;
    font-weight: bold;
    padding-right: 5px;
  }

  .inputContainer {
    position: relative;
    margin-top: 1.4rem;
  }

  .unit {
    position: relative;
    right: 3.2rem;
    color: gray;
  }
</style>
